package com.fyh.base;



/**
 * Created by Cbt on 2016/12/20.
 */
public class BasePresenter <V> {
  public  V myView;

    public void attachView(V myView) {
        this.myView = myView;
    }

    public void detachView() {
        this.myView = null;
    }


}
