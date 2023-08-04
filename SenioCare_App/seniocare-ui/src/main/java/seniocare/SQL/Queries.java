package seniocare.SQL;

public class Queries {
	public static final String getPersonFromPerson = "select \"FirstName\",\"LastName\" from \"Person\" where \"PersonId\"=?";

	public static final String getIdFromEmployee = "select \"EmpId\" from \"Employee\" where \"PersonId\"=?";

	public static final String getIdFromClient = "select \"ClientId\" from \"Client\" where \"PersonId\"=?";

	public static final String getAllCategories = "select \"Type\"  from \"Category\"";

	public static final String getParticularSubCategories = "select \"Type\" from \"SubCategory\"";

	public static final String selectEmpForRequest = "select \"EmpId\" from \"Employee\" where \"SessionActive\"=? and"
			+ " \"RequestAssigned\"=? and \"Role\"=? limit 1";

	public static final String maxReqId = "select MAX(\"ReqId\") from \"Request\"";

	public static final String insertIntoRequest = "insert into \"Request\" values(?,?,?,?,?,?,?,?,?)";

	public static final String getIdFromCategory = "select \"CategoryId\" from \"Category\" where \"Type\"=?";

	public static final String getIdFromSubCategory = "select \"SubCategoryId\" from \"SubCategory\" where \"Type\"=?";

	public static final String setEmployeeActive = "update \"Employee\" set \"SessionActive\"=? where \"EmpId\"=?";

	public static final String setRequestAssigned = "update \"Employee\" set \"RequestAssigned\"=? where \"EmpId\"=?";

	public static final String selReqForClient = "select p.\"FirstName\", p.\"LastName\", p.\"PhoneNumber\",p.\"Email\",e.\"Role\"  "
			+ "from \"Employee\" e,\"Request\" r,\"Person\" p where e.\"EmpId\"=r.\"EmpId\" and p.\"PersonId\"=e.\"PersonId\" "
			+ "and r.\"ClientId\"= ? and r.\"Status\"= ? ";

	public static final String selReqForEmp = "select r.\"ReqId\", p.\"FirstName\", p.\"LastName\", p.\"PhoneNumber\",p.\"Email\", r.\"Status\", "
			+ "r.\"Comments\" "
			+ "from \"Client\" c,\"Request\" r,\"Person\" p where c.\"ClientId\"=r.\"ClientId\" and p.\"PersonId\"=c.\"PersonId\" "
			+ "and r.\"EmpId\"= ?";

	public static final String updateResolveRequest = "update \"Request\" set \"EndTime\"=?, \"Status\"=? where \"ReqId\"=?";

	public static final String updateEmployeeResolveRequest = "update \"Employee\" set \"RequestAssigned\"=? where \"EmpId\"=?";
	
	public static final String updateEmployeeLogout = "update \"Employee\" set \"SessionActive\"=? where \"EmpId\"=?";
	
	
}
