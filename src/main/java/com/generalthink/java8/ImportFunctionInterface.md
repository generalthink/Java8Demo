
### java中的重要函数接口

接口 					参数 		返回类型 		示例							什么时候使用
Predicate<T> 		T 		boolean 	这张唱片已经发行了吗				对流中的数进行判断
Consumer<T> 		T 		void 		输出一个值						获取流中的数
Function<T,R> 		T 		R			获得 Artist对象的名字				对流中的单个数进行出来之后然后在返回
Supplier<T> 		None 	T 			工厂方法						
UnaryOperator<T> 	T 		T 			逻辑非 (!)						同Function
BinaryOperator<T> 	(T, T) 	T 			求两个数的乘积 （*）				每次处理流中的两个数,然后返回相同类型的数据