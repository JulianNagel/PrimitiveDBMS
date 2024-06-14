public class CreateTable{
    String tableQuery;
    public void defineTableQuerry(){
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("CREATE TABLE IF NOT EXISTS");
        this.tableQuery = queryBuilder.toString();
    }

}
