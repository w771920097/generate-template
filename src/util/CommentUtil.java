package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import constant.Constant;
import constant.TypeConversionEnum;
import generateplus.domain.BasicData;
import generateplus.domain.DataMeta;

/**
 * 名字转换 NameTransformation
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月25日 下午7:24:22
 *
 */
public class CommentUtil {
	
	private static BasicData basicData;
	
	public static void main(String[] args) {
		String path = Constant.FILE_PATH;
		System.out.println(File.separator);
		System.out.println(path);
		path = path.replace("/", "\\").replace("\\", File.separator);

		System.out.println(path);
	}
	
	/**
	 * 首字母大写
	 * 
	 * @param srcStr
	 * @return
	 */
	public static String toUpperCaseFirstOne(String srcStr) {
		return srcStr.substring(0, 1).toUpperCase() + srcStr.substring(1);
	}

	/**
	 * 首字母小写
	 * 
	 * @param srcStr
	 * @return
	 */
	public static String toLowerCaseFirstOne(String srcStr) {
		return srcStr.substring(0, 1).toLowerCase() + srcStr.substring(1);
	}

	/**
	 * replaceUnderlineAndfirstToUpper
	 * 
	 * @Description: 替换下划线并让它的下一个字母为大写
	 * @param source
	 * @return String 返回类型
	 */
	public static String replaceUnderlineAndfirstToUpper(String source) {
		String[] str = source.split("_");
		if (str.length < 1) {
			return source;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]);
		for (int i = 1; i < str.length; i++) {
			sb.append(toUpperCaseFirstOne(str[i]));
		}
		return sb.toString();
	}

	public static BasicData getBasicData() {
		if (basicData == null) {
			setTempBasicData();
			setExtendBasicData();
		}
		return basicData;
	}
	

	/**
	 * 设置基本的模板数据
	 * @return void    返回类型
	 */
	private static void setTempBasicData() {
		basicData = new BasicData();
		basicData.setDomainCname(Constant.DOMAIN_CNAME);
		basicData.setDomainName(Constant.DOMAIN_NAME);
		basicData.setAuthor(Constant.AUTHOR);
		basicData.setTableName(Constant.TABLE_NAME);
		basicData.setClassPath(Constant.CLASS_PAHT);
		basicData.setFilePath(Constant.FILE_PATH);
		
		basicData.setDate(getDateString(new Date()));
		
		List<DataMeta> dataMetaList = DatabaseUtil.getDataMetaListByTableName(Constant.TABLE_NAME);
		if (dataMetaList == null || dataMetaList.size() < 0) {
			throw new RuntimeException("表字段数据不存在");
		}

		basicData.setDataMetaList(dataMetaList);
		
	}
	
	/**
	 * 设置拓展的模板数据
	 * @return void    返回类型
	 */
	private static void setExtendBasicData() {
		
		List<String> columns = basicData.getColumns();
		List<String> fields = basicData.getFields();
		List<String> fieldTypes = basicData.getFieldTypes();
		List<String> upperCaseFields = basicData.getUpperCaseFields();
		List<DataMeta> dataMetaList = basicData.getDataMetaList();
		
		if (null != basicData.getDomainName()) {
			basicData.setLowerCaseDomainName(CommentUtil.toLowerCaseFirstOne(basicData.getDomainName()));
			basicData.setUpperCaseDomainName(CommentUtil.toUpperCaseFirstOne(basicData.getDomainName()));
		}
		for (DataMeta dataMeta : dataMetaList) {
			String[] columnType = dataMeta.getColumnType().split(" ");
			String fieldType = TypeConversionEnum.getJavaTypeByMysqlType(columnType[0]);
			fieldTypes.add(fieldType);
			
			String columnName = dataMeta.getColumnName();
			columns.add(columnName);
			
			String field = CommentUtil.replaceUnderlineAndfirstToUpper(columnName);
			fields.add(field);
			
			upperCaseFields.add(CommentUtil.toUpperCaseFirstOne(field));
		}
	}
	public static String getDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 如果路径不存在 ，则生成路径
	 * @param path    文件 路径
	 * @return void    返回类型
	 */
	public static void generaterPath(String path) {
	    File file = new File(path);
	    if (!file.exists()){
	      file.mkdirs();
	    }
	}

	/**
	 * 生成文件，如果已经存在则覆盖
	 * @param str	文件内容
	 * @param path    文件路径
	 * @return void    返回类型
	 */
	public static void generateFiles(String str, String path) {
		FileOutputStream fos = null;
		BufferedWriter bw = null;

		try {
			// 输出的文件夹路径
			// C:\\Users\\n-340\\Desktop\\test.txt
			fos = new FileOutputStream(path);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			bw.write(str);
			bw.flush();
			// bw.append(str);// 往已有的文件上添加字符串
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
