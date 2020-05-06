/*
 * NLP API
 * API for calling various NLP methods
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * GenericNerResultDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-30T19:45:43.640Z[GMT]")
public class GenericNerResultDto {
  @SerializedName("person")
  private List<String> person = null;

  @SerializedName("norp")
  private List<String> norp = null;

  @SerializedName("fac")
  private List<String> fac = null;

  @SerializedName("org")
  private List<String> org = null;

  @SerializedName("gpe")
  private List<String> gpe = null;

  @SerializedName("loc")
  private List<String> loc = null;

  @SerializedName("product")
  private List<String> product = null;

  @SerializedName("event")
  private List<String> event = null;

  @SerializedName("work_of_art")
  private List<String> workOfArt = null;

  @SerializedName("law")
  private List<String> law = null;

  @SerializedName("language")
  private List<String> language = null;

  @SerializedName("date")
  private List<String> date = null;

  @SerializedName("time")
  private List<String> time = null;

  @SerializedName("percent")
  private List<String> percent = null;

  @SerializedName("money")
  private List<String> money = null;

  @SerializedName("quantity")
  private List<String> quantity = null;

  @SerializedName("ordinal")
  private List<String> ordinal = null;

  @SerializedName("cardinal")
  private List<String> cardinal = null;

  @SerializedName("start")
  private String start = null;

  @SerializedName("end")
  private String end = null;

  public GenericNerResultDto person(List<String> person) {
    this.person = person;
    return this;
  }

  public GenericNerResultDto addPersonItem(String personItem) {
    if (this.person == null) {
      this.person = new ArrayList<String>();
    }
    this.person.add(personItem);
    return this;
  }

   /**
   * Get person
   * @return person
  **/
  @Schema(description = "")
  public List<String> getPerson() {
    return person;
  }

  public void setPerson(List<String> person) {
    this.person = person;
  }

  public GenericNerResultDto norp(List<String> norp) {
    this.norp = norp;
    return this;
  }

  public GenericNerResultDto addNorpItem(String norpItem) {
    if (this.norp == null) {
      this.norp = new ArrayList<String>();
    }
    this.norp.add(norpItem);
    return this;
  }

   /**
   * Get norp
   * @return norp
  **/
  @Schema(description = "")
  public List<String> getNorp() {
    return norp;
  }

  public void setNorp(List<String> norp) {
    this.norp = norp;
  }

  public GenericNerResultDto fac(List<String> fac) {
    this.fac = fac;
    return this;
  }

  public GenericNerResultDto addFacItem(String facItem) {
    if (this.fac == null) {
      this.fac = new ArrayList<String>();
    }
    this.fac.add(facItem);
    return this;
  }

   /**
   * Get fac
   * @return fac
  **/
  @Schema(description = "")
  public List<String> getFac() {
    return fac;
  }

  public void setFac(List<String> fac) {
    this.fac = fac;
  }

  public GenericNerResultDto org(List<String> org) {
    this.org = org;
    return this;
  }

  public GenericNerResultDto addOrgItem(String orgItem) {
    if (this.org == null) {
      this.org = new ArrayList<String>();
    }
    this.org.add(orgItem);
    return this;
  }

   /**
   * Get org
   * @return org
  **/
  @Schema(description = "")
  public List<String> getOrg() {
    return org;
  }

  public void setOrg(List<String> org) {
    this.org = org;
  }

  public GenericNerResultDto gpe(List<String> gpe) {
    this.gpe = gpe;
    return this;
  }

  public GenericNerResultDto addGpeItem(String gpeItem) {
    if (this.gpe == null) {
      this.gpe = new ArrayList<String>();
    }
    this.gpe.add(gpeItem);
    return this;
  }

   /**
   * Get gpe
   * @return gpe
  **/
  @Schema(description = "")
  public List<String> getGpe() {
    return gpe;
  }

  public void setGpe(List<String> gpe) {
    this.gpe = gpe;
  }

  public GenericNerResultDto loc(List<String> loc) {
    this.loc = loc;
    return this;
  }

  public GenericNerResultDto addLocItem(String locItem) {
    if (this.loc == null) {
      this.loc = new ArrayList<String>();
    }
    this.loc.add(locItem);
    return this;
  }

   /**
   * Get loc
   * @return loc
  **/
  @Schema(description = "")
  public List<String> getLoc() {
    return loc;
  }

  public void setLoc(List<String> loc) {
    this.loc = loc;
  }

  public GenericNerResultDto product(List<String> product) {
    this.product = product;
    return this;
  }

  public GenericNerResultDto addProductItem(String productItem) {
    if (this.product == null) {
      this.product = new ArrayList<String>();
    }
    this.product.add(productItem);
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @Schema(description = "")
  public List<String> getProduct() {
    return product;
  }

  public void setProduct(List<String> product) {
    this.product = product;
  }

  public GenericNerResultDto event(List<String> event) {
    this.event = event;
    return this;
  }

  public GenericNerResultDto addEventItem(String eventItem) {
    if (this.event == null) {
      this.event = new ArrayList<String>();
    }
    this.event.add(eventItem);
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @Schema(description = "")
  public List<String> getEvent() {
    return event;
  }

  public void setEvent(List<String> event) {
    this.event = event;
  }

  public GenericNerResultDto workOfArt(List<String> workOfArt) {
    this.workOfArt = workOfArt;
    return this;
  }

  public GenericNerResultDto addWorkOfArtItem(String workOfArtItem) {
    if (this.workOfArt == null) {
      this.workOfArt = new ArrayList<String>();
    }
    this.workOfArt.add(workOfArtItem);
    return this;
  }

   /**
   * Get workOfArt
   * @return workOfArt
  **/
  @Schema(description = "")
  public List<String> getWorkOfArt() {
    return workOfArt;
  }

  public void setWorkOfArt(List<String> workOfArt) {
    this.workOfArt = workOfArt;
  }

  public GenericNerResultDto law(List<String> law) {
    this.law = law;
    return this;
  }

  public GenericNerResultDto addLawItem(String lawItem) {
    if (this.law == null) {
      this.law = new ArrayList<String>();
    }
    this.law.add(lawItem);
    return this;
  }

   /**
   * Get law
   * @return law
  **/
  @Schema(description = "")
  public List<String> getLaw() {
    return law;
  }

  public void setLaw(List<String> law) {
    this.law = law;
  }

  public GenericNerResultDto language(List<String> language) {
    this.language = language;
    return this;
  }

  public GenericNerResultDto addLanguageItem(String languageItem) {
    if (this.language == null) {
      this.language = new ArrayList<String>();
    }
    this.language.add(languageItem);
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @Schema(description = "")
  public List<String> getLanguage() {
    return language;
  }

  public void setLanguage(List<String> language) {
    this.language = language;
  }

  public GenericNerResultDto date(List<String> date) {
    this.date = date;
    return this;
  }

  public GenericNerResultDto addDateItem(String dateItem) {
    if (this.date == null) {
      this.date = new ArrayList<String>();
    }
    this.date.add(dateItem);
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @Schema(description = "")
  public List<String> getDate() {
    return date;
  }

  public void setDate(List<String> date) {
    this.date = date;
  }

  public GenericNerResultDto time(List<String> time) {
    this.time = time;
    return this;
  }

  public GenericNerResultDto addTimeItem(String timeItem) {
    if (this.time == null) {
      this.time = new ArrayList<String>();
    }
    this.time.add(timeItem);
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @Schema(description = "")
  public List<String> getTime() {
    return time;
  }

  public void setTime(List<String> time) {
    this.time = time;
  }

  public GenericNerResultDto percent(List<String> percent) {
    this.percent = percent;
    return this;
  }

  public GenericNerResultDto addPercentItem(String percentItem) {
    if (this.percent == null) {
      this.percent = new ArrayList<String>();
    }
    this.percent.add(percentItem);
    return this;
  }

   /**
   * Get percent
   * @return percent
  **/
  @Schema(description = "")
  public List<String> getPercent() {
    return percent;
  }

  public void setPercent(List<String> percent) {
    this.percent = percent;
  }

  public GenericNerResultDto money(List<String> money) {
    this.money = money;
    return this;
  }

  public GenericNerResultDto addMoneyItem(String moneyItem) {
    if (this.money == null) {
      this.money = new ArrayList<String>();
    }
    this.money.add(moneyItem);
    return this;
  }

   /**
   * Get money
   * @return money
  **/
  @Schema(description = "")
  public List<String> getMoney() {
    return money;
  }

  public void setMoney(List<String> money) {
    this.money = money;
  }

  public GenericNerResultDto quantity(List<String> quantity) {
    this.quantity = quantity;
    return this;
  }

  public GenericNerResultDto addQuantityItem(String quantityItem) {
    if (this.quantity == null) {
      this.quantity = new ArrayList<String>();
    }
    this.quantity.add(quantityItem);
    return this;
  }

   /**
   * Get quantity
   * @return quantity
  **/
  @Schema(description = "")
  public List<String> getQuantity() {
    return quantity;
  }

  public void setQuantity(List<String> quantity) {
    this.quantity = quantity;
  }

  public GenericNerResultDto ordinal(List<String> ordinal) {
    this.ordinal = ordinal;
    return this;
  }

  public GenericNerResultDto addOrdinalItem(String ordinalItem) {
    if (this.ordinal == null) {
      this.ordinal = new ArrayList<String>();
    }
    this.ordinal.add(ordinalItem);
    return this;
  }

   /**
   * Get ordinal
   * @return ordinal
  **/
  @Schema(description = "")
  public List<String> getOrdinal() {
    return ordinal;
  }

  public void setOrdinal(List<String> ordinal) {
    this.ordinal = ordinal;
  }

  public GenericNerResultDto cardinal(List<String> cardinal) {
    this.cardinal = cardinal;
    return this;
  }

  public GenericNerResultDto addCardinalItem(String cardinalItem) {
    if (this.cardinal == null) {
      this.cardinal = new ArrayList<String>();
    }
    this.cardinal.add(cardinalItem);
    return this;
  }

   /**
   * Get cardinal
   * @return cardinal
  **/
  @Schema(description = "")
  public List<String> getCardinal() {
    return cardinal;
  }

  public void setCardinal(List<String> cardinal) {
    this.cardinal = cardinal;
  }

  public GenericNerResultDto start(String start) {
    this.start = start;
    return this;
  }

   /**
   * Starting time in ISO 8601 format
   * @return start
  **/
  @Schema(description = "Starting time in ISO 8601 format")
  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public GenericNerResultDto end(String end) {
    this.end = end;
    return this;
  }

   /**
   * Ending time in ISO 8601 format
   * @return end
  **/
  @Schema(description = "Ending time in ISO 8601 format")
  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericNerResultDto genericNerResultDto = (GenericNerResultDto) o;
    return Objects.equals(this.person, genericNerResultDto.person) &&
        Objects.equals(this.norp, genericNerResultDto.norp) &&
        Objects.equals(this.fac, genericNerResultDto.fac) &&
        Objects.equals(this.org, genericNerResultDto.org) &&
        Objects.equals(this.gpe, genericNerResultDto.gpe) &&
        Objects.equals(this.loc, genericNerResultDto.loc) &&
        Objects.equals(this.product, genericNerResultDto.product) &&
        Objects.equals(this.event, genericNerResultDto.event) &&
        Objects.equals(this.workOfArt, genericNerResultDto.workOfArt) &&
        Objects.equals(this.law, genericNerResultDto.law) &&
        Objects.equals(this.language, genericNerResultDto.language) &&
        Objects.equals(this.date, genericNerResultDto.date) &&
        Objects.equals(this.time, genericNerResultDto.time) &&
        Objects.equals(this.percent, genericNerResultDto.percent) &&
        Objects.equals(this.money, genericNerResultDto.money) &&
        Objects.equals(this.quantity, genericNerResultDto.quantity) &&
        Objects.equals(this.ordinal, genericNerResultDto.ordinal) &&
        Objects.equals(this.cardinal, genericNerResultDto.cardinal) &&
        Objects.equals(this.start, genericNerResultDto.start) &&
        Objects.equals(this.end, genericNerResultDto.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(person, norp, fac, org, gpe, loc, product, event, workOfArt, law, language, date, time, percent, money, quantity, ordinal, cardinal, start, end);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericNerResultDto {\n");
    
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    norp: ").append(toIndentedString(norp)).append("\n");
    sb.append("    fac: ").append(toIndentedString(fac)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    gpe: ").append(toIndentedString(gpe)).append("\n");
    sb.append("    loc: ").append(toIndentedString(loc)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    workOfArt: ").append(toIndentedString(workOfArt)).append("\n");
    sb.append("    law: ").append(toIndentedString(law)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    percent: ").append(toIndentedString(percent)).append("\n");
    sb.append("    money: ").append(toIndentedString(money)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ordinal: ").append(toIndentedString(ordinal)).append("\n");
    sb.append("    cardinal: ").append(toIndentedString(cardinal)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}