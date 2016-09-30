package kr.co.c;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.m.SangpumModel;
import kr.co.m.SawonDto;
import kr.co.m.SawonModel;
import kr.co.m.sangpumDto;

public class sawonImpl implements commandInter {
	public static sawonImpl impl = new sawonImpl();
	
	public static sawonImpl Instance(){
		return impl;
	}
	
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SawonModel model = SawonModel.Instance();
		ArrayList<SawonDto> list = model.getdataAll();
		request.setAttribute("data", list);
		return "sawon";
	}
}
