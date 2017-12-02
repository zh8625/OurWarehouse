package water.cool.coolfish.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import water.cool.coolfish.bean.ChatRecord;
import water.cool.coolfish.bean.MessageTransfer;
import water.cool.coolfish.bean.User;
import water.cool.coolfish.service.ChatService;
import water.cool.coolfish.service.UserAndFriendService;
import water.cool.coolfish.utils.ResponseJson;

@Controller("chatAction")
@Scope("prototype")
public class ChatAction extends ActionSupport implements ModelDriven<User> {
	private UserAndFriendService userAndFriendService;
	private ChatService chatService;
	//
	private User user = new User();
	private int touid;
	private String msg;

	// ��¼
	public String login() {
		HttpServletResponse response = ServletActionContext.getResponse();

		User u = userAndFriendService.login(user.getUsername(), user.getPassword());
		if (user != null) {
			try {
				PrintWriter pw = response.getWriter();
				String data = JSONObject.fromObject(u).toString();
				ResponseJson rj = new ResponseJson();
				rj.setCode(0);
				rj.setMsg("��¼�ɹ�");
				rj.setData(data);
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}

		} else {
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(-1);
				rj.setMsg("��¼ʧ��");
				rj.setData("");
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
		}
		
		return null;
	}

	// ע��

	public String reg() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			userAndFriendService.reg(user);

			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("ע��ɹ�");
			rj.setData("");
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (Exception e) {
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(-1);
				rj.setMsg("ע��ʧ��");
				rj.setData("");
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e1) {
			}
		}

		return null;
	}
	public String search() {
		HttpServletResponse response = ServletActionContext.getResponse();
		User u = userAndFriendService.search(user.getUsername());
		if(u!=null) {
			try {
				PrintWriter pw = response.getWriter();
				String data = JSONObject.fromObject(u).toString();
				ResponseJson rj = new ResponseJson();
				rj.setCode(0);
				rj.setMsg("��ѯ�ɹ�");
				rj.setData(data);
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
			
		}else {
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(-1);
				rj.setMsg("��ѯʧ��");
				rj.setData("");
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	public String addFriend() {
		HttpServletResponse response = ServletActionContext.getResponse();
		userAndFriendService.addFriend(user.getUid(), touid);
		try {
			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("��Ӻ��ѳɹ�");
			rj.setData("");
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
		return null;
	}
	public String deleteFriend() {
		HttpServletResponse response = ServletActionContext.getResponse();
		userAndFriendService.deleteFriend(user.getUid(), touid);
		try {
			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("ɾ�����ѳɹ�");
			rj.setData("");
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
		
		return null;
	}
	
	public String isFriend() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean isF = userAndFriendService.isFriend(user.getUid(), touid);
		if(isF) {
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(1);
				rj.setMsg("�Ǻ���");
				rj.setData("");
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
		}else {
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(0);
				rj.setMsg("���Ǻ���");
				rj.setData("");
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	//�����б�
		public String friendList() {
			HttpServletResponse response = ServletActionContext.getResponse();
			List<Map<String, Object>> friendList = userAndFriendService.friendList(user.getUid());
			String flj = JSONArray.fromObject(friendList).toString();
			try {
				PrintWriter pw = response.getWriter();
				ResponseJson rj = new ResponseJson();
				rj.setCode(0);
				rj.setMsg("�����б�");
				rj.setData(flj);
				String rjs = JSONObject.fromObject(rj).toString();
				pw.println(rjs);
				//�ر�
				pw.flush();
				pw.close();
			} catch (IOException e) {
			}
			
			
			return null;
		}
		
	
	public String send() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		ChatRecord cr = new ChatRecord();
		cr.setFromuid(user.getUid());
		cr.setTouid(touid);
		cr.setMessage(msg);
		cr.setCdate(new Date());
		chatService.send(cr);
		//
		try {
			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("��Ϣ�ѷ���");
			rj.setData("");
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
		
		return null;
	}
	public String receive() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<ChatRecord> lc = chatService.receive(user.getUid());
		String lcj = JSONArray.fromObject(lc).toString();
		try {
			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("δ���ܵ���Ϣ");
			rj.setData(lcj);
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
		
		return null;
	}
	
	//���ʮ����Ϣ��¼
	public String nearMess() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<MessageTransfer> lm = chatService.getMessNear(user.getUid());
		String lmj = JSONArray.fromObject(lm).toString();
		try {
			PrintWriter pw = response.getWriter();
			ResponseJson rj = new ResponseJson();
			rj.setCode(0);
			rj.setMsg("���ʮ����Ϣ��¼");
			rj.setData(lmj);
			String rjs = JSONObject.fromObject(rj).toString();
			pw.println(rjs);
			//�ر�
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
		return null;
	}
	

	@Override
	public User getModel() {
		return user;
	}

	public int getTouid() {
		return touid;
	}

	public void setTouid(int touid) {
		this.touid = touid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
