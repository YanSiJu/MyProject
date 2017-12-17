package cn.ccsu.service;

import java.util.List;
import cn.ccsu.entity.Product;

public interface IProductService {

	// 增加产品
	int addProduct(Product product);

	// 查询产品信息
	List<Product> queryProduct(String productName, Integer id);

	// 查询所有产品信息
	List<Product> queryAllProducts();

	// 更新产品信息
	int modifyProduct(Product product);

	// 删除产品信息
	void deleteProduct(Integer id);

}
