package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Comparator;
import java.util.Optional;

public enum ContentType {
	MULTIMEDIA(1), TASK(2), EVALUATION(3);

	private int order;

	private ContentType(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isMultimedia() {
		return compareTo(MULTIMEDIA) == 0;
	}

	public boolean isTask() {
		return compareTo(TASK) == 0;
	}

	public boolean isEvaluation() {
		return compareTo(EVALUATION) == 0;
	}

	public static class ContentTypeComparator implements Comparator<ContentType> {

		@Override
		public int compare(ContentType o1, ContentType o2) {
			return (o1 != null && o2 != null) ? Integer.compare(o1.getOrder(), o2.getOrder()) : 0;
		}
	}

	public static Optional<ContentType> valueFrom(String str) {
		try {
			return Optional.of(ContentType.valueOf(str));
		} catch (IllegalArgumentException | NullPointerException e) {
			return Optional.empty();
		}
	}

	public static boolean isValid(String str) {
		return valueFrom(str).isPresent();
	}
}