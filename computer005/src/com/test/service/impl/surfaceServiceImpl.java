package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.surface;
import com.test.dao.surfaceDao;
import com.test.service.surfaceService;
@Component("surfaceservice")
public class surfaceServiceImpl implements surfaceService{
	private surfaceDao surfacedao;

	public surfaceDao getSurfacedao() {
		return surfacedao;
	}
    @Resource
	public void setSurfacedao(surfaceDao surfacedao) {
		this.surfacedao = surfacedao;
	}

	public List<surface> getallimg() {
		return this.surfacedao.getallsurface();
	}

}
