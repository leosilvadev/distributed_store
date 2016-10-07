package br.leosilvadev.products.utils

import rx.Observable
import rx.Subscriber;

class React {

	static Observable when(Closure function) {
		Observable.create { Subscriber subscriber ->
			if (!subscriber.isUnsubscribed()) {
				try {
					subscriber.onNext(function())
					subscriber.onCompleted()
				} catch (ex) {
					subscriber.onError(ex)
				}
			}
		}
	}
}
