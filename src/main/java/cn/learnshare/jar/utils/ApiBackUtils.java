package cn.learnshare.jar.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling API result returns.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApiBackUtils {

	/**
	 * result fields
	 */
	private int code;

	/**
	 * message fields
	 */
	private String msg;

	/**
	 * data fields
	 */
	private Object data;

	/**
	 * default constructor
	 */
	public ApiBackUtils() {

	}

	/**
	 * constructor with code, msg, data
	 *
	 * @param code
	 * @param msg
	 * @param data
	 */
	public ApiBackUtils(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * get code
	 *
	 * @return int code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set code
	 *
	 * @param code to set code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * get message
	 *
	 * @return string message
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * set message
	 *
	 * @param msg to set message
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * get data
	 *
	 * @return object data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * set data
	 *
	 * @param data to set data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * base result
	 */
	public static ApiBackUtils base(){
		return new ApiBackUtils(0, "", null);
	}
	public static ApiBackUtils base(int code){
		return new ApiBackUtils(code, "", null);
	}
	public static ApiBackUtils base(int code, String msg){
		return new ApiBackUtils(code, msg, null);
	}
	public static ApiBackUtils base(int code, String msg, Object data){
		return new ApiBackUtils(code, msg, data);
	}

	/**
	 * success result
	 */
	public static ApiBackUtils success(String msg){
		return new ApiBackUtils(0, msg, null);
	}
	public static ApiBackUtils success(Object data){
		return new ApiBackUtils(0, "", data);
	}
	public static ApiBackUtils success(String msg, Object data){
		return new ApiBackUtils(0, msg, data);
	}

	/**
	 * error result
	 */
	public static ApiBackUtils error(String msg){
		return new ApiBackUtils(1, msg, null);
	}
	public static ApiBackUtils error(Exception e){
		e.printStackTrace();
		return new ApiBackUtils(1, e.getMessage(), null);
	}

	/**
	 * save result
	 */
	public static ApiBackUtils save(){
		return success("保存成功", null);
	}
	public static ApiBackUtils save(Integer res){
		return save(res == 1);
	}
	public static ApiBackUtils save(Integer res, Object data){
		return save(res == 1, data);
	}
	public static ApiBackUtils save(Boolean res){
		return save(res, null);
	}
	public static ApiBackUtils save(Boolean res, Object data){
		return res ? success("保存成功", data) : error("保存失败");
	}

	/**
	 * delete result
	 */
	public static ApiBackUtils remove(Integer result){
		return remove(result, null);
	}
	public static ApiBackUtils remove(Boolean result){
		return remove(result, null);
	}
	public static ApiBackUtils remove(Boolean result, Object data){
		return result ? success("删除成功", data) : error("删除失败");
	}
	public static ApiBackUtils remove(Integer res, String deleteIds){
		Integer idList = StringUtils.isNotEmpty(deleteIds) ? 1 : Arrays.asList(deleteIds.split(",")).size();
		return res == idList ? success("删除成功", deleteIds) : error("删除失败");
	}

	/**
	 *  query result
	 */
	public static ApiBackUtils query(Object o){
		return success(o);
	}
	public static ApiBackUtils query(long total, Object data){
		Map<String, Object> vo = new HashMap<>();
		vo.put("total", total);
		vo.put("data", data);
		return query(vo);
	}

	/**
	 * upload result
	 */
	public static ApiBackUtils upload(Boolean res, String fileName){
		return res ? success("上传成功", fileName) : error("上传失败");
	}

}