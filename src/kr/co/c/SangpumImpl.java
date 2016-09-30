package kr.co.c;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.m.SangpumModel;
import kr.co.m.sangpumDto;

public class SangpumImpl implements commandInter {
	public static SangpumImpl impl = new SangpumImpl();
	
	public static SangpumImpl Instance(){
		return impl;
	}
	
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SangpumModel model = SangpumModel.Instance();
		ArrayList<sangpumDto> list = model.getdataAll();
		request.setAttribute("data", list);
		return "sangpum";
	}
}
