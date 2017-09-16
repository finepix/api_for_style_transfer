package hdu.shawn.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hdu.shawn.entity.BaseTask;


/**
 * @author f-zx
 *
 */
public class TaskQueue {

		private static Queue<BaseTask> queue = new LinkedList<>();
		private static List<String> task_list = new ArrayList<>();		
//		static{
//
//			ModelTask task = new ModelTask("src/pic.jpg", "mosaic");
//			queue.offer(task);
//		}
//		
		public TaskQueue(){
		}
		
		/**
		 *  pop一个任务
		 * @return 如果存在任务则返回任务，若没有任务那么返回null，注意处理
		 */
		public static BaseTask pop(){
			BaseTask task = queue.poll();
			if(task != null)
				//删除list中的对应id，表名改任务已经不在队列中
				task_list.remove(task.getId());
			return task;
		}
		
		/**
		 * 
		 * 检查任务是否还在队列中
		 * @param taskid
		 * @return
		 */
		public static boolean contains(String taskid){
			
			return task_list.contains(taskid);
		}
		
		/**
		 * 添加任务
		 * @param task 任务
		 * @return 返回是否添加成功
		 */
		public static boolean add(BaseTask task){
			//添加到tasklist以完成遍历的时候查找
			task_list.add(task.getId());
			return queue.offer(task);
		}
		
		
		public static void main(String[] args) {
			
			System.out.println(queue.poll());
		}
}
