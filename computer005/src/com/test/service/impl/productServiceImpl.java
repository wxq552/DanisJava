package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.production;
import com.test.dao.productDao;
import com.test.service.productService;
@Component("productservice")
public class productServiceImpl implements productService{
	private productDao productdao;

	public productDao getProductdao() {
		return productdao;
	}
    @Resource
	public void setProductdao(productDao productdao) {
		this.productdao = productdao;
	}

	public boolean addProduct(production pro) {
		return this.productdao.addpro(pro);
	}
	public List<production> productdetail(int offSet, int maxResult) {
		return this.productdao.getproducts(offSet, maxResult);
	}
	public int getProcount() {
		return this.productdao.getprocount();
	}
	public boolean deletepro(production pro) {
		return this.productdao.delete(pro);
	}
	public production getSinglepro(int id) {
	    return this.productdao.getonepro(id); 
	}
	public boolean updateproduct(production pro) {
		return this.productdao.updatepro(pro);
	}
	public boolean deleteproductmulti(List<production> dellist) {
		return this.productdao.deletemulti(dellist);
	}
	public List<String> findProduct() {
		return this.productdao.findProByType();
	}
	public int getprocountByType(String type) {
		return this.productdao.getprocountBytype(type);
	}
	public List<production> getPageProType(int offSet, int maxResult,
			String type) {
		return this.productdao.getproPageType(offSet, maxResult, type);
	}

}
