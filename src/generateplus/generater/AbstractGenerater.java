package generateplus.generater;

import java.io.File;

import generateplus.domain.BasicData;
import util.CommentUtil;

/**
 * AbstractGenerater 
 * @author wangsihong@hztianque.com   
 * @date 2018年12月3日 下午1:34:58 
 *
 */
public abstract class AbstractGenerater implements Generater {
	
	private static final String separator = File.separator;
	
	protected BasicData basicData;

	protected abstract void setBasicData();

	protected abstract String building();

	public void build() {
		try {
			basicData = (BasicData) CommentUtil.getBasicData().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//设置基本数据
		setBasicData();
		//获取生成的代码
		String str = building();
		
		String path = basicData.getFilePath() + separator + basicData.getFolderName();
		try {
			CommentUtil.generaterPath(path);
		} catch (Exception e) {
			throw new RuntimeException("生成文件路径失败 路径:" + path);
		}
		
		try {
			path = path + separator + basicData.getSuffix();
			CommentUtil.generateFiles(str, path);
			System.out.println("输出路径> " + path);
		} catch (Exception e) {
			throw new RuntimeException("生成文件失败 路径:" + path);
		}
	    
	}
}
