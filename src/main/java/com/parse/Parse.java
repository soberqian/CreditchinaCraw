package com.parse;

import java.util.List;

import com.model.DetailInfoModel;
import com.model.ListInfoModel;
import com.alibaba.fastjson.JSON;



public class Parse {
	//红名单企业
	public static List<ListInfoModel> getcodedata(String jsondata){
		//采用fastjson解析json数据，这里已将json数据封装到对象fastjson中了
		List<ListInfoModel> jsonlist = JSON.parseArray(jsondata.split("results\":")[1].split(",\"exportButtonValid")[0],ListInfoModel.class);
		//返回所爬数据
		return jsonlist;
	}
	//解析每个企业的详细信息
	public static List<DetailInfoModel> getbasicinfodata(String jsondata){
		//采用fastjson解析json数据，这里已将json数据封装到对象fastjson中了
		System.out.println(jsondata.split("result\":")[1].split(",\"status")[0]);
		List<DetailInfoModel> jsonlist = JSON.parseArray("["+jsondata.split("result\":")[1].split(",\"status")[0]+"]",DetailInfoModel.class);
		System.out.println(jsonlist.get(0).getId());
		//返回所爬数据
		return jsonlist;
	}
}
