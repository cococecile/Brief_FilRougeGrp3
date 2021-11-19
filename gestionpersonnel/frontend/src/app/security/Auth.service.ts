import { HttpClient } from "@angular/common/http";
import { Injectable, OnDestroy } from "@angular/core";
import { Router } from "@angular/router";
import { BehaviorSubject, Observable, of, Subscription } from "rxjs";
import { tap, map, delay, finalize } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { ApplicationUser } from "./ApplicationUser";

interface LoginResult {
    username: string;
    role: string;
    originalUserName: string;
    accessToken: string;
    refreshToken: string;
  }

@Injectable({
    providedIn: 'root',
  })
export class AuthService implements OnDestroy {
    
    private readonly apiUrl = `${environment.apiUrl}api/account`;
    private timer: Subscription;
    private _user = new BehaviorSubject<ApplicationUser>(null);
    user$: Observable<ApplicationUser> = this._user.asObservable();
  
    /**
     * This method makes sure that when the user logs in or out, the other tabs are notified so the user is logged in/out of each of them.
     * @param event = the event that will trigger the mthod. Here, the user logging in or logging out.
     */
    private storageEventListener(event: StorageEvent) {
        if (event.storageArea === localStorage) {
          if (event.key === 'logout-event') {
            this._user.next(null);
          }
          if (event.key === 'login-event') {
            location.reload();
          }
        }
      }
  
      /**
       * This method sets an event listener that will bind the window to a Storage Event.
       * @param router 
       * @param http 
       */
    constructor(private router: Router, private http: HttpClient) {
      window.addEventListener('storage', this.storageEventListener.bind(this));
    }
  
    ngOnDestroy(): void {
      window.removeEventListener('storage', this.storageEventListener.bind(this));
    }
      
      login(username: string, password: string) {
        return this.http
          .post<LoginResult>(`${this.apiUrl}/login`, { username, password })
          .pipe(
            map((x) => {
              this._user.next({ username: x.username, role: x.role });
              this.setLocalStorage(x);
              localStorage.setItem('login-event', 'login' + Math.random());
              this.startTokenTimer();
              return x;
            })
          );
      }
      
      private getTokenRemainingTime() {
        const accessToken = localStorage.getItem('access_token');
        if (!accessToken) {
          return 0;
        }
        const jwtToken = JSON.parse(atob(accessToken.split('.')[1]));
        const expires = new Date(jwtToken.exp * 1000);
        return expires.getTime() - Date.now();
      }
      
      private startTokenTimer() {
        const timeout = this.getTokenRemainingTime();
        this.timer = of(true)
          .pipe(
            delay(timeout),
            tap(() => this.refreshToken().subscribe())
          )
          .subscribe();
      }
  
      logout() {
        this.http
          .post<unknown>(`${this.apiUrl}/logout`, {})
          .pipe(
            finalize(() => {
              this.clearLocalStorage();
              this._user.next(null);
              this.stopTokenTimer();
              this.router.navigate(['login']);
            })
          )
          .subscribe();
      }
  
        refreshToken() {
            const refreshToken = localStorage.getItem('refresh_token');
            if (!refreshToken) {
              this.clearLocalStorage();
              return of(null);
            }
        }
  
            setLocalStorage(x: LoginResult) {
                localStorage.setItem('access_token', x.accessToken);
                localStorage.setItem('refresh_token', x.refreshToken);
                localStorage.setItem('login-event', 'login' + Math.random());
              }
  
        clearLocalStorage() {
            localStorage.removeItem('access_token');
            localStorage.removeItem('refresh_token');
            localStorage.setItem('logout-event', 'logout' + Math.random());
          }
    
    private stopTokenTimer() {
      this.timer?.unsubscribe();
    }
  }
