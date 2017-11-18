package weatherStepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import weatherStepDefs.model.WeatherModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class WeatherStepDefs {
    private String cityName;
    private WeatherModel weatherModel;
    private WeatherRequester weatherRequester = new WeatherRequester();

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() throws IOException {
        weatherModel = weatherRequester.getWeather(cityName);
    }

    @Then("Coordinates are lon:(.*) and lat:(.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat) {
        Assert.assertEquals("Longitude is incorrect", lon.stripTrailingZeros(), weatherModel.getCoord().getLon().stripTrailingZeros());
        Assert.assertEquals("Latitude is incorrect", lat.stripTrailingZeros(), weatherModel.getCoord().getLat().stripTrailingZeros());
    }

    @Then("Weather is:")
    public void checkWeather(Map<String, String> weather) {
        BigDecimal weatherId = new BigDecimal(weather.get("id")).stripTrailingZeros();
        Assert.assertEquals("Weather id is incorrect", weatherId, weatherModel.getWeather().get(0).getId().stripTrailingZeros());
        Assert.assertEquals("Weather main is incorrect", weather.get("main"), weatherModel.getWeather().get(0).getMain());
        Assert.assertEquals("Weather description is incorrect", weather.get("description"), weatherModel.getWeather().get(0).getDescription());
        Assert.assertEquals("Weather icon is incorrect", weather.get("icon"), weatherModel.getWeather().get(0).getIcon());
    }

    @Then("Base is (.*)")
    public void checkBase(String base) {
        Assert.assertEquals("Base is incorrect", base, weatherModel.getBase());
    }

    @Then("Main is:")
    public void checkMain(Map<String, BigDecimal> main) {
        Assert.assertEquals("Main temp is incorrect", main.get("temp").stripTrailingZeros(), weatherModel.getMain().getTemp().stripTrailingZeros());
        Assert.assertEquals("Main pressure is incorrect", main.get("pressure").stripTrailingZeros(), weatherModel.getMain().getPressure().stripTrailingZeros());
        Assert.assertEquals("Main humidity is incorrect", main.get("humidity").stripTrailingZeros(), weatherModel.getMain().getHumidity().stripTrailingZeros());
        Assert.assertEquals("Main temp_min is incorrect", main.get("temp_min").stripTrailingZeros(), weatherModel.getMain().getTemp_min().stripTrailingZeros());
        Assert.assertEquals("Main temp_max is incorrect", main.get("temp_max").stripTrailingZeros(), weatherModel.getMain().getTemp_max().stripTrailingZeros());
    }

    @Then("Visibility is (.*)")
    public void checkVisibility(BigDecimal visibility) {
        Assert.assertEquals("Visibility is incorrect", visibility.stripTrailingZeros(), weatherModel.getVisibility().stripTrailingZeros());
    }

    @Then("Wind is:")
    public void checkWind(Map<String, BigDecimal> wind) {
        Assert.assertEquals("Wind speed is incorrect", wind.get("speed").stripTrailingZeros(), weatherModel.getWind().getSpeed().stripTrailingZeros());
        Assert.assertEquals("Wind deg is incorrect", wind.get("deg").stripTrailingZeros(), weatherModel.getWind().getDeg().stripTrailingZeros());
    }

    @Then("Clouds are (.*)")
    public void checkClouds(BigDecimal cloudsAll) {
        Assert.assertEquals("Clouds all are incorrect", cloudsAll.stripTrailingZeros(), weatherModel.getClouds().getAll().stripTrailingZeros());
    }

    @Then("Dt is (.*)")
    public void checkDt(BigDecimal dt) {
        Assert.assertEquals("Dt is incorrect", dt.stripTrailingZeros(), weatherModel.getDt().stripTrailingZeros());
    }

    @Then("Sys is:")
    public void checkSys(Map<String, String> sys) {
        BigDecimal sysType = new BigDecimal(sys.get("type")).stripTrailingZeros();
        BigDecimal sysId = new BigDecimal(sys.get("id")).stripTrailingZeros();
        BigDecimal sysMessage = new BigDecimal(sys.get("message")).stripTrailingZeros();
        BigDecimal sysSunrise = new BigDecimal(sys.get("sunrise")).stripTrailingZeros();
        BigDecimal sysSunset = new BigDecimal(sys.get("sunset")).stripTrailingZeros();
        Assert.assertEquals("Sys type is incorrect", sysType, weatherModel.getSys().getType().stripTrailingZeros());
        Assert.assertEquals("Sys id is incorrect", sysId, weatherModel.getSys().getId().stripTrailingZeros());
        Assert.assertEquals("Sys message is incorrect", sysMessage, weatherModel.getSys().getMessage().stripTrailingZeros());
        Assert.assertEquals("Sys country is incorrect", sys.get("country"), weatherModel.getSys().getCountry());
        Assert.assertEquals("Sys sunrise is incorrect", sysSunrise, weatherModel.getSys().getSunrise().stripTrailingZeros());
        Assert.assertEquals("Sys sunset is incorrect", sysSunset, weatherModel.getSys().getSunset().stripTrailingZeros());
    }

    @Then("Id is (.*)")
    public void checkId(BigDecimal id) {
        Assert.assertEquals("Id is incorrect", id.stripTrailingZeros(), weatherModel.getId().stripTrailingZeros());
    }

    @Then("Name is (.*)")
    public void checkName(String name) {
        Assert.assertEquals("Name is incorrect", name, weatherModel.getName());
    }

    @Then("Cod is (.*)")
    public void checkCod(BigDecimal cod) {
        Assert.assertEquals("Cod is incorrect", cod.stripTrailingZeros(), weatherModel.getCod().stripTrailingZeros());
    }
}
