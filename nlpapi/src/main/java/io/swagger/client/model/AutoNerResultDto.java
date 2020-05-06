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
 * AutoNerResultDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-30T19:45:43.640Z[GMT]")
public class AutoNerResultDto {
  @SerializedName("per")
  private List<String> per = null;

  @SerializedName("org")
  private List<String> org = null;

  @SerializedName("loc")
  private List<String> loc = null;

  @SerializedName("start")
  private String start = null;

  @SerializedName("end")
  private String end = null;

  public AutoNerResultDto per(List<String> per) {
    this.per = per;
    return this;
  }

  public AutoNerResultDto addPerItem(String perItem) {
    if (this.per == null) {
      this.per = new ArrayList<String>();
    }
    this.per.add(perItem);
    return this;
  }

   /**
   * Get per
   * @return per
  **/
  @Schema(description = "")
  public List<String> getPer() {
    return per;
  }

  public void setPer(List<String> per) {
    this.per = per;
  }

  public AutoNerResultDto org(List<String> org) {
    this.org = org;
    return this;
  }

  public AutoNerResultDto addOrgItem(String orgItem) {
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

  public AutoNerResultDto loc(List<String> loc) {
    this.loc = loc;
    return this;
  }

  public AutoNerResultDto addLocItem(String locItem) {
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

  public AutoNerResultDto start(String start) {
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

  public AutoNerResultDto end(String end) {
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
    AutoNerResultDto autoNerResultDto = (AutoNerResultDto) o;
    return Objects.equals(this.per, autoNerResultDto.per) &&
        Objects.equals(this.org, autoNerResultDto.org) &&
        Objects.equals(this.loc, autoNerResultDto.loc) &&
        Objects.equals(this.start, autoNerResultDto.start) &&
        Objects.equals(this.end, autoNerResultDto.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(per, org, loc, start, end);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AutoNerResultDto {\n");
    
    sb.append("    per: ").append(toIndentedString(per)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    loc: ").append(toIndentedString(loc)).append("\n");
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
