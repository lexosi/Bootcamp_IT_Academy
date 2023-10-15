package handler;

public enum EFileType {
  FILE,
  DIRECTORY;

  private static final int MAX_AMOUNT = 2;

  private final String PARSED_TYPE;

  EFileType() {
    final char CURRENT_LETTER = this.name().toLowerCase().charAt(0);

    final int CURRENT_INDEX = this.ordinal();
    final int AFTER_INDEXES = EFileType.MAX_AMOUNT - 1 - CURRENT_INDEX;

    this.PARSED_TYPE = "-".repeat(CURRENT_INDEX) + CURRENT_LETTER + "-".repeat(AFTER_INDEXES);
  }

  public String getParsedType() {
    return this.PARSED_TYPE;
  }
}
