package com.java.test.json_and_object;

public class Test
{
	public static void main(String[] args)
	{
		test1();
	}

	private static void test1()
	{
		/* Object to JSON */
		User user = new User();

		user.setAge(23);
		user.setName("zxp");
		String[] hoby = { "eat", "sleep" };
		user.sethoby(hoby);
		Small small = new Small();
		small.setA("aa");
		small.setB("bb");
		user.setSmall(small);

		String jsonStr = JsonUtils.serialize(user);
		System.out.println(jsonStr);
		/* JSON to Object */
		// String jsonStr =
		// "{\"name\":\"zxp\",\"age\":23,\"hoby\":[\"eat\",\"sleep\"],\"small\":{\"a\":\"aa\",\"b\":"bb"}}";
		User jsonUser = JsonUtils.deserialize(jsonStr, User.class);
		System.out.println(jsonUser.getName());
		System.out.println(jsonUser.getAge());
		System.out.println(jsonUser.gethoby()[0] + " and " + jsonUser.gethoby()[1]);
		System.out.println(jsonUser.getSmall().getA());
		System.out.println(jsonUser.getSmall().getB());
	}
}
