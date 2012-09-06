package com.test.json;

public class Applicant {

	// LOAN
	private String balance = "";
	private String loanAmount = "";
	private String nextPayDate = "";

	// LOAN FOR APPLY FOR NEW LOAN

	private String followingPayDate = "";

	// PERSONAL DETAILS
	private String forename = "";
	private String surname = "";
	private String addressLine1 = "";
	private String addressLine2 = "";
	private String postcode = "";
	private String mobilePhone = "";
	private String homePhone = "";

	private String title = "";
	private String middleName = "";
	private String dateOfBirth = "";
	private String gender = "";
	private String maritalStatus = "";

	// CONTACT

	private String homeStatus = "";
	private String county = "";
	private String town = "";
	private String email = "";

	private String monthsAtAddress = "";

	// WORK DETAILS

	private String employersName = "";
	private String employerPosition = "";
	private String workPhone = "";

	private String employmentStatus = "";
	private String monthlyIncome = "";
	private String Industry = "";
	private String monthsAtEmployer = "";
	private String incomeFrequency = "";

	// BANK DETAILS
	private String bankName = "";
	private String sortCode = "";
	private String cardNumber = "";
	private String cardStartDate = "";
	private String cardExpiryDate = "";
	private String status = "";

	private String accountNumber = "";
	private String cardType = "";

	private String howAreYouPaid = "";

	// Terms and Cond

	private String tickReceiveMarketing = "";
	private String agreeTermsandCond = "";

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getHowAreYouPaid() {
		return howAreYouPaid;
	}

	public void setHowAreYouPaid(String howAreYouPaid) {
		this.howAreYouPaid = howAreYouPaid;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getNextPayDate() {
		return nextPayDate;
	}

	public void setNextPayDate(String nextPayDate) {
		this.nextPayDate = nextPayDate;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getEmployersName() {
		return employersName;
	}

	public void setEmployersName(String employersName) {
		this.employersName = employersName;
	}

	public String getEmployerPosition() {
		return employerPosition;
	}

	public void setEmployerPosition(String employerPosition) {
		this.employerPosition = employerPosition;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardStartDate() {
		return cardStartDate;
	}

	public void setCardStartDate(String cardStartDate) {
		this.cardStartDate = cardStartDate;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	private static Applicant instance = new Applicant();

	private Applicant() {
	}

	public static synchronized Applicant getInstance() {
		return instance;
	}

	public void doSomething() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
		}
	}

	public String getFollowingPayDate() {
		return followingPayDate;
	}

	public void setFollowingPayDate(String followingPayDate) {
		this.followingPayDate = followingPayDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHomeStatus() {
		return homeStatus;
	}

	public void setHomeStatus(String homeStatus) {
		this.homeStatus = homeStatus;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMonthsAtAddress() {
		return monthsAtAddress;
	}

	public void setMonthsAtAddress(String monthsAtAddress) {
		this.monthsAtAddress = monthsAtAddress;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public String getMonthsAtEmployer() {
		return monthsAtEmployer;
	}

	public void setMonthsAtEmployer(String monthsAtEmployer) {
		this.monthsAtEmployer = monthsAtEmployer;
	}

	public String getIncomeFrequency() {
		return incomeFrequency;
	}

	public void setIncomeFrequency(String incomeFrequency) {
		this.incomeFrequency = incomeFrequency;
	}

	public String getTickReceiveMarketing() {
		return tickReceiveMarketing;
	}

	public void setTickReceiveMarketing(String tickReceiveMarketing) {
		this.tickReceiveMarketing = tickReceiveMarketing;
	}

	public String getAgreeTermsandCond() {
		return agreeTermsandCond;
	}

	public void setAgreeTermsandCond(String agreeTermsandCond) {
		this.agreeTermsandCond = agreeTermsandCond;
	}

	public void initializeData() {

		setBalance("444");
		setLoanAmount("555");
		setNextPayDate("3/01/81");
		setForename("Javier");
		setSurname("Vargas");
		setAddressLine2("Aguascalientes");
		setPostcode("20089");
		setMobilePhone("07904296316");
		setHomePhone("4499165961");
		setEmployersName("HotSprings Technologies");
		setEmployerPosition("Technologies");
		setWorkPhone("9160625");
		setBankName("BBVA Bancomer");
		setSortCode("1231321");
		setCardNumber("4152310422431537");
		setCardStartDate("1/1/81");
		setCardExpiryDate("2/2/82");

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone is not allowed.");
	}
}
