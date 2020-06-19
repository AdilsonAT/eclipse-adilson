package CenariosBusPay;

public class Payroll {

		private String cenarioPay;
		private String statusPay;
		private String cenarioBus;
		private String statusBus;
		
		public Payroll(String cenarioPay, String statusPay, String cenarioBus, String statusBus) {
			this.cenarioPay = cenarioPay;
			this.statusPay = statusPay;
			this.cenarioBus = cenarioBus;
			this.statusBus = statusBus;
		}
		public String getCenarioPay() {
			return cenarioPay;
		}
		public void setCenarioPay(String cenarioPay) {
			this.cenarioPay = cenarioPay;
		}
		public String getStatusPay() {
			return statusPay;
		}
		public void setStatusPay(String statusPay) {
			this.statusPay = statusPay;
		}
		public String getCenarioBus() {
			return cenarioBus;
		}
		public void setCenarioBus(String cenarioBus) {
			this.cenarioBus = cenarioBus;
		}
		public String getStatusBus() {
			return statusBus;
		}
		public void setStatusBus(String statusBus) {
			this.statusBus = statusBus;
		}
		@Override
		public String toString() {
			return "Payroll [cenarioPay=" + cenarioPay + ", statusPay=" + statusPay + ", cenarioBus=" + cenarioBus
					+ ", statusBus=" + statusBus + "]";
		}		
}
