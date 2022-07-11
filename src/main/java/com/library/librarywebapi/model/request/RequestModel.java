package com.library.librarywebapi.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestModel {
    Long id;
    String libraryName;
    String authorName;
    String title;
    String chargesFee;
    String price;
    String categoryName;
    String image;
}
