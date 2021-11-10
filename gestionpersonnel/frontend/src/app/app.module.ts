import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { XyzComponent } from './xyz/xyz.component';
=======
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
>>>>>>> 41e969bae022551904ca4f42a9e6741cb65b75b0

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    AddTutorialComponent,
    TutorialDetailsComponent,
    TutorialsListComponent,
    XyzComponent
=======
    HeaderComponent,
    FooterComponent
>>>>>>> 41e969bae022551904ca4f42a9e6741cb65b75b0
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
