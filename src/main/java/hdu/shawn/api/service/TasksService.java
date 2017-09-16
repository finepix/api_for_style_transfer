package hdu.shawn.api.service;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hdu.shawn.api.response.BaseResponse;
import hdu.shawn.api.response.ResponseBuilder;
import hdu.shawn.entity.BaseTask;
import hdu.shawn.entity.ColorPreserveTask;
import hdu.shawn.entity.CustomizedTask;
import hdu.shawn.entity.FinishTask;
import hdu.shawn.entity.ModelTask;
import hdu.shawn.utils.TaskComplitedTable;
import hdu.shawn.utils.TaskQueue;

@RestController
@RequestMapping("/tasks")
public class TasksService {

	private static Logger log = Logger.getLogger(TasksService.class);
	
	@RequestMapping(value="/pop",method=RequestMethod.GET)
	public BaseResponse pop(){
		BaseTask task = TaskQueue.pop();
		
		if(task != null){
			log.info(task);
			return ResponseBuilder.build(0, "", task);
		}
			
		else
			return ResponseBuilder.build(1, "no job", null);
	}
	
	@RequestMapping(value="/add/model", method=RequestMethod.POST)
	public BaseResponse addModelTask(@ModelAttribute ModelTask task){
		
//		System.out.println(task.getModel_name());
		if(TaskQueue.add(task))
			return ResponseBuilder.build(0, "model job added.", task);
		else
			return ResponseBuilder.build(1, "add failed.", null);
	}
	
	@RequestMapping(value="/add/color", method=RequestMethod.POST)
	public BaseResponse addColorTask(@ModelAttribute ColorPreserveTask task){
		
		if(TaskQueue.add(task))
			return ResponseBuilder.build(0, "color preserve job added.", task);
		else
			return ResponseBuilder.build(1, "add failed.", null);
	}
	
	@RequestMapping(value="/add/customized", method=RequestMethod.POST)
	public BaseResponse addCumstomizedTask(@ModelAttribute CustomizedTask task){
		
		if(TaskQueue.add(task))
			return ResponseBuilder.build(0, "cumstomized job added.", task);
		else
			return ResponseBuilder.build(1, "add failed.", null);
	}
	
	@RequestMapping(value="/{taskid}", method=RequestMethod.GET)
	public BaseResponse queryByTaskID(@PathVariable("taskid") String taskID){
		FinishTask task = null;
		
		if(TaskComplitedTable.contains(taskID)){
			task = new FinishTask();
			task.setId(taskID);
			task.setResult(TaskComplitedTable.getValue(taskID));
			return ResponseBuilder.build(0, "", task);
			
		}else if (TaskQueue.contains(taskID)) {
			return ResponseBuilder.build(2, "the task is still in the que.", null);
		}else {
			return ResponseBuilder.build(1, "working on it!", null);
		}
		
	}

	@RequestMapping(value="/finish", method=RequestMethod.POST)
	public BaseResponse compliteTask(@ModelAttribute FinishTask task){
		if(TaskComplitedTable.setTask(task))
			return ResponseBuilder.build(0, "job finish", null);
		else
			return ResponseBuilder.build(1, "commit failed", null);
	}
}
