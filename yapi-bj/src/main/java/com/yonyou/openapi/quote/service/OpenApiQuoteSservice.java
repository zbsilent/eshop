package com.yonyou.openapi.quote.service;
  import com.yonyou.openapi.quote.entity.OpenApiQuoteItem;
  import com.yonyou.openapi.quote.mapper.OpenApiQuoteDao;
  import com.yonyou.openapi.quote.mapper.OpenApiQuoteItemDao;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenApiQuoteSservice {

    @Autowired
    private OpenApiQuoteDao openApiQuoteDao;
    @Autowired
    private OpenApiQuoteItemDao openApiQuoteItemDao;


    public String query(Integer id){
        return openApiQuoteDao.findAll(id).toString();
    }

    public String queryByQuoteId(Integer id){
        return openApiQuoteItemDao.findByQuoteId(id).toString();
    }

}
