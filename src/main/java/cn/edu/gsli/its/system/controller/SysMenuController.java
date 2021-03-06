package cn.edu.gsli.its.system.controller;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.system.entity.SysMenu;
import cn.edu.gsli.its.system.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	
	@Resource
	private SysMenuService menuService;
	
	@RequestMapping("listUI")
	//@RequiresPermissions("sys:menu:view")
	public String listUI(){
		return "system/menu_list";
	}
	
	/**
	 * æ¥æ¾æ?æèå?
	 * @param entity
	 * @return
	 */
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String, Object>> list =
				menuService.findObjects();
		return new JsonResult(list);
	}
	
	/**
	 * æ°å¢
	 */
	@RequestMapping("editUI")
	public String editUI(){
		return "system/menu_edit";
	}
	
	/**
	 * å è½½éæ©èåæ ç»æ?
	 */
	@RequestMapping("treeUI")
	@ResponseBody
	public JsonResult treeUI(){
		List<Map<String, Object>> list =
		menuService.findZtreeNodes();
		return new JsonResult(list);
	}
	
	/**
	 * æ·»å èå
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult save(SysMenu entity){
		menuService.saveObject(entity);
		return new JsonResult();
	}
	
	/**
	 * æ ¹æ®idæ¥è¯¢èåä¿¡æ¯ 
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer menuId){
		Map<String, Object> map =
		menuService.findMapById(menuId);
		return new JsonResult(map);
	}
	
	/**updateMenu*/
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		menuService.updateObject(entity);
		return new JsonResult();
	}
	
	/** å¤æ­è¦å é¤çèåæ¯å¦æå­èå*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer menuId){
		menuService.deleteObject(menuId);
		return new JsonResult();
	}

}
