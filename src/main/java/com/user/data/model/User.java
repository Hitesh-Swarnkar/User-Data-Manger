package com.user.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {
	private Long userId;
	private String userName;
	private String serviceLine;
}
