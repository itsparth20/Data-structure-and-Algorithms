
import java.math.BigDecimal;

class Model {

	private String recordType;
	private String transactionCode;
	private String cardNumber;
	private String merchantCategoryCode;
	private String filler;
	private String originalTransactionDate;
	private BigDecimal amount;
	SupplementryData supplementryData;

	public Model(String recordType, String transactionCode, String cardNumber, String merchantCategoryCode,
			String filler, String originalTransactionDate, BigDecimal amount) {
		super();
		this.recordType = recordType;
		this.transactionCode = transactionCode;
		this.cardNumber = cardNumber;
		this.merchantCategoryCode = merchantCategoryCode;
		this.filler = filler;
		this.originalTransactionDate = originalTransactionDate;
		this.amount = amount;
		this.supplementryData = null;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}

	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getOriginalTransactionDate() {
		return originalTransactionDate;
	}

	public void setOriginalTransactionDate(String originalTransactionDate) {
		this.originalTransactionDate = originalTransactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public SupplementryData getSupplementryData() {
		return supplementryData;
	}

	public void setSupplementryData(SupplementryData supplementryData) {
		this.supplementryData = supplementryData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((filler == null) ? 0 : filler.hashCode());
		result = prime * result + ((merchantCategoryCode == null) ? 0 : merchantCategoryCode.hashCode());
		result = prime * result + ((originalTransactionDate == null) ? 0 : originalTransactionDate.hashCode());
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + ((supplementryData == null) ? 0 : supplementryData.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (filler == null) {
			if (other.filler != null)
				return false;
		} else if (!filler.equals(other.filler))
			return false;
		if (merchantCategoryCode == null) {
			if (other.merchantCategoryCode != null)
				return false;
		} else if (!merchantCategoryCode.equals(other.merchantCategoryCode))
			return false;
		if (originalTransactionDate == null) {
			if (other.originalTransactionDate != null)
				return false;
		} else if (!originalTransactionDate.equals(other.originalTransactionDate))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (supplementryData == null) {
			if (other.supplementryData != null)
				return false;
		} else if (!supplementryData.equals(other.supplementryData))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		return true;
	}

	static class SupplementryData {
		String recordType;
		String transactionCode;
		String cardNumber;
		String sdtDescription;

		public SupplementryData(String recordType, String transactionCode, String cardNumber, String sdtDescription) {
			this.recordType = recordType;
			this.transactionCode = transactionCode;
			this.cardNumber = cardNumber;
			this.sdtDescription = sdtDescription;
		}

		public String getRecordType() {
			return recordType;
		}

		public void setRecordType(String recordType) {
			this.recordType = recordType;
		}

		public String getTransactionCode() {
			return transactionCode;
		}

		public void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public String getSdtDescription() {
			return sdtDescription;
		}

		public void setSdtDescription(String sdtDescription) {
			this.sdtDescription = sdtDescription;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
			result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
			result = prime * result + ((sdtDescription == null) ? 0 : sdtDescription.hashCode());
			result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SupplementryData other = (SupplementryData) obj;
			if (cardNumber == null) {
				if (other.cardNumber != null)
					return false;
			} else if (!cardNumber.equals(other.cardNumber))
				return false;
			if (recordType == null) {
				if (other.recordType != null)
					return false;
			} else if (!recordType.equals(other.recordType))
				return false;
			if (sdtDescription == null) {
				if (other.sdtDescription != null)
					return false;
			} else if (!sdtDescription.equals(other.sdtDescription))
				return false;
			if (transactionCode == null) {
				if (other.transactionCode != null)
					return false;
			} else if (!transactionCode.equals(other.transactionCode))
				return false;
			return true;
		}
	}
}
