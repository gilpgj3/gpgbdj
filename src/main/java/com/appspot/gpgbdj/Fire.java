package com.appspot.gpgbdj;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class Fire {
	private static final FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
			.setProjectId("gpgbdj").build();
	public static final Firestore BD = firestoreOptions.getService();
}