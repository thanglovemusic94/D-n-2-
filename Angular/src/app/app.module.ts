import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ContentComponent } from './content/content.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './content/footer/footer.component';
import { HeaderContentComponent } from './content/header-content/header-content.component';
import { LeftMenuComponent } from './left-menu/left-menu.component';
import { ContentMainComponent } from './content/content-main/content-main.component';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    HeaderComponent,
    FooterComponent,
    HeaderContentComponent,
    LeftMenuComponent,
    ContentMainComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
