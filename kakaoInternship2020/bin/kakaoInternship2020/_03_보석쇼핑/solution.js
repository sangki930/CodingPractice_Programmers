function solution(gems){
  var count = new Set(gems).size;
  // 보석 종류가 몇개인지 
  var gemMap = new Map()
  // 보석 종류 => 보석 자리를 저장하기 위한 맵
  var gemLength = []
  // 보석을 모두 포함하는 구간을 저장할 배열 
  gems.forEach((gem, i)=> {
    gemMap.delete(gem)
    gemMap.set(gem, i)
    if(gemMap.size === count){
        
        let s=gemMap.values().next().value;
      gemLength.push([s+1, i+1])
    }
  })
  // console.log(gems.length);
    // console.log(gemLength);
  gemLength.sort((a,b)=> {
    if(a[1]-a[0] === b[1]-b[0]){
      return a[1]-b[1]
    }
    return (a[1]-a[0])-(b[1]-b[0])
  })
  
  return gemLength[0]
}