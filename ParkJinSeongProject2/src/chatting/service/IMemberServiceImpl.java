package chatting.service;

import java.util.Vector;

import chatting.model.MemberDAO;
import chatting.model.MemberDTO;


public class IMemberServiceImpl implements IMemberService{
   
   //[멤버변수]
   private MemberDAO dao;
   
   public IMemberServiceImpl(String url, String user, String password) {
      dao = new MemberDAO(url, user, password);
   }/////////////////////////

   @Override
   public Vector<Vector> selectList(MemberDTO dto) throws Exception {
      
      return dao.selectList(dto);
   }///////////////////////

   @Override
   public MemberDTO selectOne(MemberDTO dto) throws Exception {
	   
      return dao.selectOne(dto);
   }/////////////////////

   @Override
   public int insert(MemberDTO dto) throws Exception {
      
      return dao.insert(dto);
   }////////////////////////

   @Override
   public int delete(MemberDTO dto) throws Exception {
      
      return dao.delete(dto);
   }///////////////////////

   @Override
   public int update(MemberDTO dto) throws Exception {
      
      return dao.update(dto);
   }/////////////////////

   @Override
   public void close() {
      
   }/////////////////

}////////////class