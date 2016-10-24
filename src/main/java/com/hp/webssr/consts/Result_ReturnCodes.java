package com.hp.webssr.consts;

/*
 * define some return codes for every Result-Class
 * */
public class Result_ReturnCodes {
	/*
	 * the action you call for is done successfully
	 * */
	public static final String Successfully="ok";
	/*
	 * the action you call for failed for some reason,
	 * more error information, you can visit the other field
	 * */
	public static final String Failed="notok";
	/**
	 * when the return class inits, the return-code is first be filled with this
	 * */
	public static final String InitError="initerror";
	
}
