package com.imooc.Controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController("buyer")
@RequestMapping("/buyer")
public class BuyerProductController {


    @Resource
    private ProductService productService;
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/saveProductInfo",method = RequestMethod.POST)
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        return productService.save(productInfo);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public Page<ProductInfo> findAll(int page, int size) {
        PageRequest pageRequest = new PageRequest(page, size);
//        Pageable pageRequest = new PageRequest(page, size);  pageable是接口
        return productService.findAll(pageRequest);
    }

    @GetMapping("/list")
    public ResultVO list() {


        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //!!!通过遍历并组装好的List结合，获得ProductCategory对象集合，
        //接着遍历ProductCategory对象集合，弄好ProductVO的对象集合，

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
//            productVO.setProductInfoVOList(productService.findByTypeIn());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);


    }
}
