package com.hd.mutismart.main.entity;

import lombok.Data;

/**
 * @author hunter
 */
@Data
public class EmailMessage {

    private String from;
    private String to;
    private String title;
    private String context;
}
