package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.TopMenuAndSearchSection;
import pl.akademiaqa.pages.section.TopNavigationSection;

@Getter
public class HomePage {


    private TopMenuAndSearchSection topMenuAndSearchSection;
    private TopNavigationSection topNavigationSection;

    public HomePage(Page page) {
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }
}
