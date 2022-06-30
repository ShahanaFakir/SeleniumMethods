package hw13_1;

public class DynamicXPath {
	
	
	/*
	 * Source: 
	 * https://www.bestbuy.com/
	 * https://www.macys.com/
	 * 
	 * Tag with a single attribute:
	 * 1.//input[@class='search-input'] Best Buy search field
	 * 2.//input[@id='gh-search-input'] Best Buy search field
	 * 3.//button[@class='c-button-unstyled hamburger-menu-button'] Best Buy Menu button
	 * 4.//span[@class='store-display-name'] Best Buy store display name
	 * 5.//input[@id='globalSearchInputField'] macys search field
	 */
	
	/*
	 * Source:
	 * https://www.bestbuy.com/
	 * 
	 * Tag with multiple attribute with "or" logic
	 * 1.//input[@id='gh-search-input' or @class='search-input'] Best Buy search field
	 * 2.//input[@name='st' or @id='gh-search-input'] Best Buy search field
	 * 3.//span[@class='cart-label' or @text()='Cart'] Best Buy Cart button
	 * 4.//input[@id='search-input' or @name='st'] Best Buy search field
	 * 5.//input[@id='gh-search-input' or @class='search-input' or @name='st'] Best Buy search field
	 */
	
	/*
	 * Source:
	 * https://www.target.com/
	 * https://www.jcpenney.com/
	 * 
	 * Tag with multiple attribute with and logic
	 * 1.//input[@id='searchInputId' and @class='_8TGe3'] JCpenny search field
	 * 2.//a[@id='jcp-logo' and @class='iQ2RY WWfmV'] JCpenny logo 
	 * 3.//input[@class='_8TGe3' and @name='Ntt'] JCpenny search field
	 * 4.//input[@class='styles__SearchInput-sc-17dxxwu-13 gbZEQs' and @id='search']Target search field
	 * 5.//a[@class='Link__StyledLink-sc-4b9qcv-0 styles__StyledLink-sc-1ghv6mc-2 ghasId ckIRoZ h-text-sm h-text-white h-padding-a-none h-margin-l-jumbo' and @id='utilityNav-registries']Target registry button
	 */
	
	/*
	 * Source:
	 * https://www.target.com/
	 * 
	 * Tag with inner text
	 * 1.//span[text()='Sign in'] Sign in button
	 * 2.//a[text()='Registry'] Registry button
	 * 3.//div[text()='Jackson Heights'] Jackson Heights location button
	 * 4.//span[text()='Get the deals'] Get the deals button
	 * 5.//span[text()='My Store']My store button
	 */
	
	/*
	 * Source:
	 * https://www.target.com/
	 * 
	 * Tag with inner text (not complete inner text rather partial text)
	 * 1. Complete inner text: //span[contains(text(), 'Get the deals')]
	 * Partial inner text: //span[contains(text(), 'Get t')] Get the deals button
	 * 
	 * 2.Complete inner text: //div[contains(text(), 'Jackson Heights')]
	 * Partial inner text: //div[contains(text(), 'J')] Jackson Heights location button
	 * 
	 * 3.Complete inner text: //span[contains(text(), 'Sign in')]
	 * Partial inner text: //span[contains(text(), 'Sig')] Target Sign in button
	 * 
	 * 4.Complete inner text: //span[contains(text(), 'Sizzling deals for the Fourth. Ends Monday, 7/4.')]
	 * Partial inner text: //span[contains(text(), 'Siz')] Sizzling deals for the fourth ends of Monday,7/4.
	 * 
	 * 5.Complete inner text: //b[contains(text(), 'outdoor furniture & decor*')]
	 * Partial inner text://b[contains(text(), 'o')] outdoor furniture & decor*
	 */
	
	/*
	 * Source
	 * https://www.target.com/
	 * 
	 * Tag with contains and attribute
	 * 1.//span[contains(@class, 'styles__AccountLinkText-sc-17dxxwu-18 fSzIDB h-margin-r-x3')] sign in button
	 * 2.//input[contains(@id, 'search')] Search field
	 * 3.//a[contains(@id, 'utilityNav-registries')]Registry button
	 * 4.//div[contains(@class, 'styles__StyledMessage-sc-1ghv6mc-5 bwxTd')] Jackson Heights button
	 * 5.//div[contains(@class, 'styles__BaseCopy-sc-1ealqwt-22 nnhzw extralarge')]Deal of the day
	 */
	
	/*
	 * Source
	 * https://www.mountsinai.org/
	 * https://www.chase.com/
	 * https://www.nychealthandhospitals.org/elmhurst/
	 * 
	 * Normalize Space
	 * 1.//h1[normalize-space(text())='FIND A DOCTOR'] Elmhurst Hospital Find a Doctor button
	 * 2.//a[normalize-space(text())='Schedule a Meeting']Chase Bank Schedule a meeting button
	 * 3.//a[normalize-space(text())='Customer Service']Chase Bank Customer Service button
	 * 4.//a[normalize-space(text())='Español']Chase Bank Espanol button
	 * 5.//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']Mount Sinai Request an appointment
	 */
	
	/*
	 * Source
	 * https://www.mountsinai.org/
	 * 
	 * Starts with
	 * 1. Complete: //p[starts-with(text(), 'The Mount Sinai Health System offers unparalleled clinical care, backed by advanced research and expertise in all medical disciplines.')]
	 * //p[starts-with(text(), 'The Mount Sinai Health System offers unparalleled clinical care, backed by advanced research and expertise in all medical disciplines.')]Mount Sinai Patient care and service
	 * 
	 * 2.Complete: //p[starts-with(text(), 'Each year, more than 50 million people in the United States suffer from allergies.')]
	 * //p[starts-with(text(), 'E')] Mount Sinai about us
	 * 
	 * 3.Complete: //p[starts-with(text(), 'The most common allergens responsible for allergic reactions are:')]
	 * //p[starts-with(text(), 'The m')] Mount Sinai About Us
	 * 
	 * 4.Complete://p[starts-with(text(), 'You have access to the vast resources of the Mount Sinai Tisch Cancer Center, including')]
	 * //p[starts-with(text(), 'You ')] Mount Sinai Cancer
	 * 
	 * 5.//p[starts-with(text(), 'For 2021-2022, Neurosurgery and Neurology at The Mount Sinai Hospital rank 10th in the nation for neurological surgery, according to')]
	 * //p[starts-with(text(), 'For')]Mount Sinai Neurosurgery
	 */
	
	/*
	 * Source
	 * https://www.target.com/
	 * 
	 * Starts with attribute
	 * 1.//input[starts-with(@id, 'search')]Target search field
	 * 2.//span[starts-with(@class, 'styles__AccountLinkText-sc-17dxxwu-18 fSzIDB h-margin-r-x3')]Sign in button
	 * 3.//div[starts-with(@class, 'styles__StyledMessage-sc-1ghv6mc-5 bwxTd')]Jackson Heights
	 * 4.//input[starts-with(@class, 'styles__SearchInput-sc-17dxxwu-13 gbZEQs')]Search field
	 * 5.//h2[starts-with(@class, 'Heading__StyledHeading-sc-1mp23s9-0 styles__StyledHeading-sc-vn03og-4 UABvu gAWgrI')]Account button
	 */

}
