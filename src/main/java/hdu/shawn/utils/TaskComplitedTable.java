package hdu.shawn.utils;

import java.util.Hashtable;

import hdu.shawn.entity.FinishTask;

public class TaskComplitedTable {
	
	private static Hashtable< String, String> finishTable = new Hashtable<>();
	
	
	/**
	 * 
	 * 检查是否存在该任务，或者说该任务是否完成
	 * @param id
	 * @return
	 */
	public static boolean contains(String id){
		return finishTable.containsKey(id);
	}
	
	/**
	 * 
	 * 查询任务完成的结果文件
	 * @param id
	 * @return
	 */
	public static String getValue(String id){
		return finishTable.get(id);
	}
	
	public static boolean setTask(FinishTask task){
		if (task == null)
			return false;
		finishTable.put(task.getId(), task.getResult());
		return true;
	}
	
	public static void main(String[] args) {
		finishTable.put("1", "test");
		System.out.println(finishTable.containsKey("1"));
	}

}
