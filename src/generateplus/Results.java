package generateplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Constant;
import generateplus.generater.AbstractGenerater;
import generateplus.generater.impl.ControllerGenerater;
import generateplus.generater.impl.DialogModeGenerater;
import generateplus.generater.impl.DlgJspGenerater;
import generateplus.generater.impl.DomainGenerater;
import generateplus.generater.impl.DomainNameValidatorGenerater;
import generateplus.generater.impl.DomainValidatorGenerater;
import generateplus.generater.impl.JavaMapperGenerater;
import generateplus.generater.impl.ListJspGenerater;
import generateplus.generater.impl.ServcieGenerater;
import generateplus.generater.impl.ServiceImplGenerater;
import generateplus.generater.impl.ValidateResultGenerater;
import generateplus.generater.impl.VoGenerater;
import generateplus.generater.impl.XmlMapperGenerater;

/**
 * Results
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年12月3日 下午1:35:18
 */
public class Results {

	private static Map<String, AbstractGenerater> map = new HashMap<String, AbstractGenerater>();

	static {
		AbstractGenerater XmlMapperGenerater = new XmlMapperGenerater();
		AbstractGenerater controllerGenerater = new ControllerGenerater();
		AbstractGenerater domainGenerater = new DomainGenerater();
		AbstractGenerater listJspGenerater = new ListJspGenerater();
		AbstractGenerater dlgJspGenerater = new DlgJspGenerater();
		AbstractGenerater javaMapperGenerater = new JavaMapperGenerater();
		AbstractGenerater servcieGenerater = new ServcieGenerater();
		AbstractGenerater serviceImplGenerater = new ServiceImplGenerater();
		AbstractGenerater voGenerater = new VoGenerater();
		AbstractGenerater dialogModeGenerater = new DialogModeGenerater();
		AbstractGenerater validateResultGenerater = new ValidateResultGenerater();
		AbstractGenerater domainValidatorGenerater = new DomainValidatorGenerater();
		AbstractGenerater domainNameValidatorGenerater = new DomainNameValidatorGenerater();
		
		map.put("controller", controllerGenerater);
		map.put("dlgJsp", dlgJspGenerater);
		map.put("domain", domainGenerater);
		map.put("javaMapper", javaMapperGenerater);
		map.put("listJsp", listJspGenerater);
		map.put("service", servcieGenerater);
		map.put("serviceImpl", serviceImplGenerater);
		map.put("xmlMapper", XmlMapperGenerater);
		map.put("vo", voGenerater);
		map.put("dialogMode", dialogModeGenerater);
		map.put("validateResult", validateResultGenerater);
		map.put("domainValidator", domainValidatorGenerater);
		map.put("domainNameValidator", domainNameValidatorGenerater);
		
		//TODO 注册

	}

	public static void main(String[] args) {
		List<String> successList = new ArrayList<String>();
		List<String> failList = new ArrayList<String>();
		// 获取需要生成的文件类型
		String fileType = Constant.FILE_TYPE;
		String[] types = fileType.split(",");
		for (String type : types) {
			System.out.println(type);
			if (type != null && !"".equals(type)) {
				AbstractGenerater abstractGenerater = map.get(type);
				if (abstractGenerater != null) {
					abstractGenerater.build();
					successList.add(type);
				} else {
					failList.add(type);
				}
			}
		}
		System.out.println(String.format("成功生成文件的有：%s \n失败的有：%s \n失败：%d 个", String.join(",", successList),
				String.join(",", failList), failList.size()));
	}
}
