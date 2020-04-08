package cn.edu.cdu.wjl.Entity;

public class Admin {

        private int admin_id;//管理员id
        private String admin_name;//管理员用户名
        private String admin_pwd;//管理员密码

        public int getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(int admin_id) {
            this.admin_id = admin_id;
        }

        public String getAdmin_name() {
            return admin_name;
        }

        public void setAdmin_name(String admin_name) {
            this.admin_name = admin_name;
        }

        public String getAdmin_pwd() {
            return admin_pwd;
        }

        public void setAdmin_pwd(String admin_pwd) {
            this.admin_pwd = admin_pwd;
        }

}
