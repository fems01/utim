package com.jmu.utim.common;

import com.jmu.utim.entity.Menu;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lrui1
 * @description 菜单通知类
 * @date: 2023/6/12
 */
@Component
@Aspect
public class MenuAspect {
    /**
     * 切入点返回值为Menu MenuService 里的方法
     * 切入位置的注解内的值，要填写全限定类名。否则有可能找不到需要的切点
     */
    @Pointcut("execution(java.util.List<com.jmu.utim.entity.Menu> com.jmu.utim.service.MenuService.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        List<Menu> menus = (List<Menu>) pjp.proceed();
        List<MenuVo> res = transform(menus, 0L);
        System.out.println(res);
        return res;
    }

    private List<MenuVo> transform(List<Menu> allMenu, Long parentId) {
        List<MenuVo> resultList = new ArrayList<>();
        if(allMenu == null) {
            return null;
        }
        for(Menu menu : allMenu) {
            if(parentId.equals(menu.getParentId())) {
                MenuVo menuVo = new MenuVo();
                BeanUtils.copyProperties(menu, menuVo);
                //递归查询子菜单，并封装信息
                List<MenuVo> childList = transform(allMenu, menu.getId());
                menuVo.setChildMenu(childList);
                resultList.add(menuVo);
            }
        }
        return resultList;
    }
}
