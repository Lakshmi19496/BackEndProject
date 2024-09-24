package pojoUtility;

public class PaymentPojo {
	public String order_id;
	public String callback_url;
	public String payment_mode_code;
	public String card_details;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getCallback_url() {
		return callback_url;
	}
	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}
	public String getPayment_mode_code() {
		return payment_mode_code;
	}
	public void setPayment_mode_code(String payment_mode_code) {
		this.payment_mode_code = payment_mode_code;
	}
	public String getCard_details() {
		return card_details;
	}
	public void setCard_details(String card_details) {
		this.card_details = card_details;
	}
	public PaymentPojo() {}
	public PaymentPojo(String order_id, String callback_url, String payment_mode_code, String card_details) {
		super();
		this.order_id = order_id;
		this.callback_url = callback_url;
		this.payment_mode_code = payment_mode_code;
		this.card_details = card_details;
	}


}
