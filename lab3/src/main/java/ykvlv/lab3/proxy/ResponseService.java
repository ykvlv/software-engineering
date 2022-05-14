package ykvlv.lab3.proxy;

import ykvlv.lab3.bean.ResponseBean;
import ykvlv.lab3.dao.ResponseDao;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public class ResponseService {
    private final ResponseDao responseDao = new ResponseDao();

    public List<ResponseBean> selectAll() {
        try {
            return responseDao.findAll();
        } catch (ServiceException e){
            return null;
        }
    }

    public void deleteAll() {
        try {
            responseDao.delete();
        } catch (ServiceException ignored){}
    }

    public void insert(ResponseBean bean){
        try {
            responseDao.save(bean);
        } catch (ServiceException ignored){}
    }
}
