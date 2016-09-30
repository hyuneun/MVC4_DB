package kr.co.c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface commandInter {
	String showData(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
