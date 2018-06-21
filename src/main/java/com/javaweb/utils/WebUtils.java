package com.javaweb.utils;

import java.util.UUID;

public class WebUtils {

	public static String makeId(){
		return UUID.randomUUID().toString();
	}
}
