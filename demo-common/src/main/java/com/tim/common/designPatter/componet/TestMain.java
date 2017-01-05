package com.tim.common.designPatter.componet;

/**
 * Created by tim.syh on 2016/8/26.
 */
public class TestMain {

	public static void main(String[] args) {
		ICategory iCategory = initCategory();
		CategoryServcie categoryService = new CategoryServiceImpl(iCategory);

		ICategory categoryRoot = categoryService.getRootCategory();
		System.out.println(categoryRoot.getName());
	}

	private static ICategory initCategory(){
		ICategory category1 = new CategoryParentDo(1, 0, "cloth");
		category1.add(new CategoryDo(11, 1, "男装"));
		category1.add(new CategoryDo(12, 1, "女装"));
		category1.add(new CategoryDo(13, 1, "童装"));

		ICategory category2 = new CategoryParentDo(2, 0, "food");
		category2.add(new CategoryDo(21, 2, "牛奶"));
		category2.add(new CategoryDo(22, 2, "水果"));
		category2.add(new CategoryDo(23, 2, "坚果"));

		ICategory category = new CategoryParentDo(0, -1, "root");
		category.add(category1);
		category.add(category2);
		return category;
	}

}
