package pink.dcc.ufla.br.wiplayer.utils.routing;

/**
 * Created by barba on 7/21/17.
 */

public class DataTransferService {
    
    private static DataTransferService instance;
    private RouteData data;
    
    private DataTransferService() {

    }
    
    public static DataTransferService getInstance() {
        if (instance == null) {
            instance = new DataTransferService();
        }
        return instance;
    }

    public RouteData getData() {
        return data;
    }

    public void setData(RouteData data) {
        this.data = data;
    }
}
