package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegistrationSteps {


    RegistrationPage registrationPage =new RegistrationPage();
    Faker faker=new Faker();

    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }

    @Given("user enters ssn number")
    public void user_enters_ssn_number() {
        String ssn=faker.idNumber().ssnValid();
        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn);
    }

    @Given("user enters firstname")
    public void user_enters_firstname() {
        String firstname=faker.name().firstName();
        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname);

    }

    @Given("user enters lastname")
    public void user_enters_lastname() {
        String lastname=faker.name().lastName();
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname);

    }

    @Given("user provides username")
    public void user_provides_username() {
        String username=faker.name().username();
        Driver.waitAndSendText(registrationPage.usernameTextbox,username);
    }

    @Given("user provides email")
    public void user_provides_email() {
        String email=faker.internet().emailAddress();
        Driver.waitAndSendText(registrationPage.emailTextbox,email);
    }
    String password="";
    @Given("user provides firstPassword")
    public void user_provides_first_password() {
        password=faker.internet().password(8,20,true,true);
        Driver.waitAndSendText(registrationPage.firstPasswordTextbox,password);
    }
    @Given("user provides secondPassword")
    public void user_provides_second_password() {
        Driver.waitAndSendText(registrationPage.secondPasswordTextbox,password);
    }

    @Given("user clicks on register button")
    public void user_clicks_on_register_button() {
        Driver.waitAndClick(registrationPage.registerButton);
    }
    @Then("user verifies the success message as {string}")
    public void user_verifies_the_message_as(String string) {
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.successMessage,3).isDisplayed());
    }


}
