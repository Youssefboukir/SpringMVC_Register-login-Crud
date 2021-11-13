/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author YOUSSEF
 */
public interface IServices <T> {

    public int insert(T M);

    public int update(T M);

    public int delete(T M);

    public T getone(T M);

    public List<T> Select();
}