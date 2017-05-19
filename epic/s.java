public List<String> WellOrderedString(int n){
	List<String> ans = new ArrayList<String>();
	ans.add("");
	if(n<=0) return ans;
	while(n-->=1){
		List<String> list = new ArrayList<String>();
		for(String curStr:ans){
			if(curStr.length()==0){
				for(int i=0;i<26-n;i++){
					list.add(curStr+(char) (i+'a'));
					list.add(curStr+(char) (i+'A'));
				}
			}else{

				char last = curStr.charAt(curStr.length()-1);
				int start = last - 'A';
				if(last>='a'){
					start = last-'a';
				}
				if(start+1>26-n) break;
				for(int i=start+1;i<26;i++){
					list.add(curStr+(char) (i+'a'));
					list.add(curStr+(char) (i+'A'));
				}

			}
		}
		ans = list;
	}
	return ans;
}




int size; 
void dig_gen(int m,int n, char* passwd) 
{ 
	int i,j; 
	if(n==size-1) 
	{ 
		for(i=m;i<=9;i++) 
		{ 
			passwd[n]='0'+i; 
			for(j=0; j<size; j++) 
				printf("%c",passwd[j]); 
			printf("\n"); 
		} 
	} 
	else 
	{ 
		for(i=m;i<10-size+n+1;i++) 
		{ 
			passwd[n]='0'+i; 
			dig_gen(i+1,n+1,passwd); 
		} 
	} 
} 
void main() 
{ 
	char* passwd; 
	scanf("%d",&size); 
	passwd=malloc(sizeof(char)*size); 
	dig_gen(0,0,passwd); 
	free(passwd); 
}
